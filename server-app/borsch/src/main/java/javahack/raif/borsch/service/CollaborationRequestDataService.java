package javahack.raif.borsch.service;

import javahack.raif.borsch.domain.CollaborationRequest;
import javahack.raif.borsch.domain.User;
import javahack.raif.borsch.domain.ids.CollaborationRequestId;
import javahack.raif.borsch.dto.CollaborationRequestDto;
import javahack.raif.borsch.enums.CollaborationRequestStatus;
import javahack.raif.borsch.enums.CollaborationRequestType;
import javahack.raif.borsch.repo.CollaborationRequestRepo;
import javahack.raif.borsch.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollaborationRequestDataService {

    private final CollaborationRequestRepo colRepo;
    private final UserRepo userRepo;

    public Set<CollaborationRequestDto> getCollaborationRequestsByUserId(UUID userId) {
        Set<CollaborationRequest> colRequests = colRepo.findAllByUserId(userId);
        return colRequests.stream()
            .map(CollaborationRequestDto::new)
            .collect(Collectors.toSet());

    }

    public Integer updateCollaborationStatusRequestById(
        CollaborationRequestStatus status, UUID userToId, UUID userFromId, UUID id
    ) {
        return colRepo.updateCollaborationlRequestStatusById(
            status.name(), userToId, userFromId, id
        );
    }

    public String addCollaborationRequest(UUID userId, UUID userToId, String text) {
        Optional<User> userTo = userRepo.findById(userToId);
        Optional<User> userFrom = userRepo.findById(userId);
        if (!userTo.isPresent()) {
            throw new RuntimeException("Не найден пользователь, которому отправляется запрос.(Id=" + userToId + ")");
        }
        if (!userFrom.isPresent()) {
            throw new RuntimeException("Не найден пользователь, который отправляет запрос.(Id=" + userId + ")");
        }

        CollaborationRequest in = new CollaborationRequest(
            new CollaborationRequestId(
                userToId,
                userId,
                UUID.randomUUID()
            ),
            LocalDate.now(),
            userTo.get().getName(),
            userFrom.get().getName(),
            text,
            CollaborationRequestStatus.PENDING,
            CollaborationRequestType.IN
        );
        CollaborationRequest out = new CollaborationRequest(
            new CollaborationRequestId(
                userId,
                userToId,
                UUID.randomUUID()
            ),
            LocalDate.now(),
            userFrom.get().getName(),
            userTo.get().getName(),
            text,
            CollaborationRequestStatus.PENDING,
            CollaborationRequestType.OUT
        );
        String inId = colRepo.save(in).getId().getId().toString();
        String outId = colRepo.save(out).getId().getId().toString();
        JSONObject res = new JSONObject();
        res.put("inId", inId);
        res.put("outId", outId);
        return res.toJSONString();
    }
}

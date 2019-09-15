package javahack.raif.borsch.service;

import javahack.raif.borsch.domain.CollaborationRequest;
import javahack.raif.borsch.domain.ids.CollaborationRequestId;
import javahack.raif.borsch.dto.CollaborationRequestDto;
import javahack.raif.borsch.enums.CollaborationRequestStatus;
import javahack.raif.borsch.repo.CollaborationRequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollaborationRequestDataService {

    private final CollaborationRequestRepo colRepo;

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

    public UUID addCollaborationRequest(UUID userId, UUID userToId, String text) {
        CollaborationRequest obj = new CollaborationRequest(
                new CollaborationRequestId(
                        userToId,
                        userId,
                        UUID.randomUUID()
                ),
                LocalDate.now(),
                text,
                CollaborationRequestStatus.PENDING
        );
        return colRepo.save(obj).getId().getId();
    }
}

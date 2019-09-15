import { v4 } from 'uuid';
// const API_URL = 'http://localhost:8080'
const API_URL = 'http://192.168.43.27:8080';


function makeHeaders(method='PUT') {
  const headers = new Headers();

  headers.append('Content-Type', 'application/json');
  headers.append('Accept', 'application/json');

  headers.append('Access-Control-Allow-Origin', '*');
  headers.append('Access-Control-Allow-Credentials', 'true');

  // headers.append('GET', 'POST', 'OPTIONS', 'PUT');
  // headers.append('PUT', 'GET', 'POST', 'OPTIONS');

  return headers;
}

export function authorize({ email, userName }) {
  const url = `${API_URL}/authorize`
  const options = {
    method: 'POST',
    body: JSON.stringify({
      email,
      userName,
    }),
    headers: makeHeaders(),
  }

  return fetch(url, options)
    .then((response) => {
      return response.json();
    })
    .catch((err) => {
      console.error(err);
    });
}

export function getUserImages() {
  const url = `https://randomuser.me/api/?results=10`
  const options = {
    method: 'GET',
    // body: JSON.stringify({
    //   email,
    //   userName,
    // }),
    // headers: makeHeaders(),
  }

  return fetch(url, options)
    .then((response) => {
      return response.json();
    })
    .catch((err) => {
      console.error(err);
    });
}

export function getUserCards(userId) {
  // let url = `${API_URL}/getUserCards?userId=${userId}`;
  let url = `${API_URL}/api/user/${userId}/cards`;
  // Object.keys(payload).forEach(key => url = `${url}${key}=${payload[key]}&`);

  const options = {
    method: 'GET',
    // body: JSON.stringify({
    //   email,
    //   userName,
    // }),
    // headers: makeHeaders(),
  }

  return fetch(url, options)
    .then((response) => {
      return response.json();
    })
    .catch((err) => {
      console.error(err);
    });
}

export function getCardTransactions(cardId) {
  let url = `${API_URL}/api/card/${cardId}/transactions`;
  // Object.keys(payload).forEach(key => url = `${url}${key}=${payload[key]}&`);

  const options = {
    method: 'GET',
    // body: JSON.stringify({
    //   email,
    //   userName,
    // }),
    headers: makeHeaders(),
  }

  return fetch(url, options)
    .then((response) => {
      return response.json();
    })
    .catch((err) => {
      console.error(err);
    });
}

export function getRecommendations(userId) {
  let url = `${API_URL}/api/user/${userId}/recommendations?limit=10`;
  // Object.keys(payload).forEach(key => url = `${url}${key}=${payload[key]}&`);

  const options = {
    method: 'GET',
    // body: JSON.stringify({
    //   email,
    //   userName,
    // }),
    headers: makeHeaders(),
  }

  return fetch(url, options)
    .then((response) => {
      return response.json();
    })
    .catch((err) => {
      console.error(err);
    });
}

export function collaborate(userId, toUserId, text) {
  let url = `${API_URL}/api/user/${userId}/request/${toUserId}`;
  // Object.keys(payload).forEach(key => url = `${url}${key}=${payload[key]}&`);

  const options = {
    method: 'PUT',
    body: JSON.stringify(text),
    headers: makeHeaders(),
  }

  return fetch(url, options)
    .then((response) => {
      return response.json();
    })
    .catch((err) => {
      console.error(err);
    });
}

export function getCollaborationRequests(userId) {
  let url = `${API_URL}/api/user/${userId}/collaborationRequests`;

  const options = {
    method: 'GET',
    // body: JSON.stringify(text),
    headers: makeHeaders(),
  }

  return fetch(url, options)
    .then((response) => {
      return response.json();
    })
    .catch((err) => {
      console.error(err);
    });
}

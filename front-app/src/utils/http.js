import { v4 } from 'uuid';
const API_URL = 'http://localhost:8080'


function makeHeaders() {
  const headers = new Headers();

  headers.append('Content-Type', 'application/json');
  headers.append('Accept', 'application/json');

  headers.append('Access-Control-Allow-Origin', '*');
  headers.append('Access-Control-Allow-Credentials', 'true');

  headers.append('GET', 'POST', 'OPTIONS');

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

export function getDogs() {
  const url = `https://dog.ceo/api/breeds/image/random/3`
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

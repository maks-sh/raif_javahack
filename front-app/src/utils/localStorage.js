export function setItem(key, payload) {
  if (!key || !payload) return;

  localStorage.setItem(key, JSON.stringify(payload))
};


export function getItem(key) {
  try {
    const data = localStorage.getItem(key);

    return JSON.parse(data);
  } catch (err) {
    return null;
  }
}
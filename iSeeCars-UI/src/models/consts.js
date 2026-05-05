let API_BASE_URL;

switch (process.env.NODE_ENV) {
  case "development":
    API_BASE_URL = "http://localhost:8080/api";
    break;

  default:
    API_BASE_URL = "http://localhost:8080/api";
    break;
}

export { API_BASE_URL };

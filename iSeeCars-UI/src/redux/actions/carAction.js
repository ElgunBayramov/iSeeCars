import { createAsyncThunk } from "@reduxjs/toolkit";
import api from "../../services/api";

export const fetchAllCars = createAsyncThunk("car/getAllCars", async () => {
  const response = await api.get("/car/getAllCars");
  return response.data;
});

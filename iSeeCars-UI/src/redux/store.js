import { configureStore } from "@reduxjs/toolkit";
import carReducer from "./reducers/carReducer";

export const store = configureStore({
    reducer: {
        car: carReducer
    }
})
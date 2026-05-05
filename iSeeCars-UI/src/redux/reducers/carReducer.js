import { createSlice } from "@reduxjs/toolkit";
import { fetchAllCars } from "../actions/carAction";

export const carReducer = createSlice({
    name:"car",
    initialState: {
        cars:[],
        loading:false,
        error:null,
    },
    reducers:{},
    extraReducers:(builder) => {
        builder
        .addCase(fetchAllCars.pending, (state) => {
            state.loading = true;
        })
        .addCase(fetchAllCars.fulfilled, (state,action) => {
            state.cars = action.payload;
            state.loading = false;
        })
        .addCase(fetchAllCars.rejected, (state) => {
            state.loading = false;
            state.error = action.error.message;
        })
        
    }
});

export default carReducer.reducer;
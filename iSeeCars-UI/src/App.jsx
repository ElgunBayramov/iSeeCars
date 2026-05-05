import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchAllCars } from "./redux/actions/carAction";

function App() {
  const dispatch = useDispatch();
  const { cars, loading, error } = useSelector((state) => state.car);

  useEffect(() => {
    dispatch(fetchAllCars());
  }, [dispatch]);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <div>
      <h1>Cars</h1>

      {cars.map((car) => (
        <div key={car.carId}>
          <p>{car.modelName}</p>
          <p>{car.price}</p>
          <p>{car.color}</p>
          <p>{car.engine}</p>
          <p>{car.year}</p>
        </div>
      ))}
    </div>
  );
}

export default App;
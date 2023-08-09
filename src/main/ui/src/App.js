import logo from './logo.svg';
import './App.css';
import HomeCard from "./components/HomeCard.tsx";
import HomeButtons from "./components/HomeButtons.tsx";

function App() {
  return (
    <div className="App">
        <HomeCard />
        <HomeButtons />
    </div>
  );
}

export default App;

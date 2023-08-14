import './App.css';
import {Routes, Route} from 'react-router-dom';
import HomeView from "./views/HomeView.tsx";
import AddNewBookView from "./views/AddNewBookView.tsx";
import DeleteBookView from "./views/DeleteBookView.tsx";


function App() {
  return (
    <div className="App">
        <Routes>
            <Route path='/' element={<HomeView />} />
            <Route path='/add-new-book' element={<AddNewBookView />} />
            <Route path='/delete' element={<DeleteBookView />} />
        </Routes>
    </div>
  );
}

export default App;

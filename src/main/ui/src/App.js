import './App.css';
import {Routes, Route} from 'react-router-dom';
import HomeView from "./views/HomeView.tsx";
import AddNewBookView from "./views/AddNewBookView.tsx";
import DeleteBookView from "./views/DeleteBookView.tsx";
import AddNewPatronView from "./views/AddNewPatronView.tsx";
import UpdatePatronView from "./views/UpdatePatronView.tsx";
import DeletePatronView from "./views/DeletePatronView.tsx";


function App() {
  return (
    <div className="App">
        <Routes>
            <Route path='/' element={<HomeView />} />
            <Route path='/add-new-book' element={<AddNewBookView />} />
            <Route path='/delete-book' element={<DeleteBookView />} />
            <Route path='/add-new-patron' element={<AddNewPatronView />} />
            <Route path='/update-patron' element={<UpdatePatronView />} />
            <Route path='/delete-patron' element={<DeletePatronView /> } />
        </Routes>
    </div>
  );
}

export default App;

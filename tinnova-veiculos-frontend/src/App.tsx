import React from 'react';
import { 
  Routes,
  Route, 
  HashRouter} from 'react-router-dom';
import FormVeiculos from './pages/FormVeiculos';
import ListaVeiculos from './pages/ListaVeiculos';

const App:React.FC = () => {
  return (
    <HashRouter>
      <div className="App">
        <Routes>
          <Route path="/" element={<ListaVeiculos />} />
          <Route path="/form" element={<FormVeiculos />} />
          <Route path="/form/:id" element={<FormVeiculos />} />
        </Routes>
      </div>
    </HashRouter>
    
  );
}

export default App;

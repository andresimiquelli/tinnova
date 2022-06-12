import React from 'react';
import { 
  Routes,
  Route, 
  HashRouter} from 'react-router-dom';
import FormVeiculos from './pages/FormVeiculos';
import ListaVeiculos from './pages/ListaVeiculos';
import ListaMarcas from './pages/ListaMarcas';
import ListDecadas from './pages/ListaDecadas';

const App:React.FC = () => {
  return (
    <HashRouter>
      <div className="App">
        <Routes>
          <Route path="/" element={<ListaVeiculos />} />
          <Route path="/form" element={<FormVeiculos />} />
          <Route path="/form/:id" element={<FormVeiculos />} />
          <Route path="/por-marca" element={<ListaMarcas />} />
          <Route path="/por-decada" element={<ListDecadas />} />
          <Route path="/ultima-semana" element={<ListaVeiculos lasWeek />} />
        </Routes>
      </div>
    </HashRouter>
    
  );
}

export default App;

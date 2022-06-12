import React from 'react';
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

import '../Header/index.css'

const Navbar: React.FC = () => {

    const navigate = useNavigate()

    return (
        <div>
            <Button variant='info' onClick={() => navigate('/')}>Lista completa</Button> &nbsp;
            <Button variant='info' onClick={() => navigate('/por-decada')}>Por década</Button> &nbsp;
            <Button variant='info' onClick={() => navigate('/por-marca')}>Por Marca</Button> &nbsp;
            <Button variant='info' onClick={() => navigate('/ultima-semana')}>Última semana</Button> &nbsp;
        </div>
    );
}

export default Navbar;
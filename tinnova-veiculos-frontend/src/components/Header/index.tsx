import React from 'react';
import { Col, Container, Row } from 'react-bootstrap';

import '../Header/index.css';
import Navbar from '../Navbar';
import TotalEstoque from '../TotalEstoque';

interface HeaderProps {
    title: string;
}

const Header: React.FC<HeaderProps> = ( props ) => {
    return (
        <header className='pageHeader'>
            <Container>
                <Row className='pb-3 pt-3'>
                    <Col>
                        <h3>{props.title}</h3>
                    </Col>
                    <Col lg={'2'}>
                        <TotalEstoque />
                    </Col>
                    <Col>                        
                        <Navbar />
                    </Col>
                </Row>
            </Container>
            
        </header>
    );
}

export default Header;
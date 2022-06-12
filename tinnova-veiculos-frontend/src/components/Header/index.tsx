import React from 'react';
import { Col, Container, Row } from 'react-bootstrap';

import '../Header/index.css';

interface HeaderProps {
    title: string;
}

const Header: React.FC<HeaderProps> = ( props ) => {
    return (
        <header className='pageHeader'>
            <Container>
                <Row className='pb-3 pt-3'>
                    <Col>
                        <h1>{props.title}</h1>
                    </Col>
                </Row>
            </Container>
            
        </header>
    );
}

export default Header;
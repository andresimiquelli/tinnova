import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Col, Container, Row, Table } from 'react-bootstrap';
import Header from '../components/Header';
import { apiUrl } from '../config';

interface item {
    marca: string;
    total: number;
}

const ListaMarca: React.FC = () => {

    const[items,setItems] = useState([] as item[])

    useEffect(() => {
        loadData()
    },[])

    function loadData() {
        axios.get(apiUrl+'/veiculos/total/marcas')
        .then(
            response => {
                setItems(response.data)
            }
        )
    }

    return (
        <>
            <Header title='Veículos por marca' />
            <Container>
                <Row>
                    <Col>
                        <Table>
                            <thead>
                                <tr>
                                    <th>Marca</th>
                                    <th>Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    items.map( item => (
                                        <tr key={item.marca}>
                                            <td>{item.marca}</td>
                                            <td>{item.total}</td>
                                        </tr>
                                    ))
                                }
                            </tbody>
                        </Table>
                    </Col>
                </Row>
            </Container>
        </>
    );
}

export default ListaMarca;
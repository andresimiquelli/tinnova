import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Col, Container, Row, Table } from 'react-bootstrap';
import Header from '../components/Header';
import { apiUrl } from '../config';

interface item {
    decada: number;
    total: number;
}

const ListDecadas: React.FC = () => {

    const[items, setItems] = useState([] as item[])

    useEffect(() => {
        loadData()
    },[])

    function loadData() {
        axios.get(apiUrl+'/veiculos/total/decadas')
        .then(
            response => {
                setItems(response.data)
            }
        )
        .catch(
            error => {
                console.log(error)
                alert("Erro ao carregar lista")
            }
        )
    }

    return (
        <>
            <Header title='Veículos por década' />
            <Container>
                <Row>
                    <Col>
                        <Table>
                            <thead>
                                <tr>
                                    <th>Década</th>
                                    <th>Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    items.map( item => (
                                        <tr key={item.decada}>
                                            <td>{item.decada}</td>
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

export default ListDecadas;
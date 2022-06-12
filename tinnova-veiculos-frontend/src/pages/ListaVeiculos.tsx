import React, { useState, useEffect } from 'react';
import { Button, Col, Container, Row, Table } from 'react-bootstrap';
import axios from 'axios';
import { apiUrl } from '../config';
import 'bootstrap/dist/css/bootstrap.min.css';

import { AiFillEdit } from 'react-icons/ai';
import Header from '../components/Header';

interface veiculo {
    id: number;
    veiculo: string;
    marca: string;
    ano: number;
    cor: string;
    descricao: string;
    vendido: boolean;
    created: string;
    updated: string;
}

const ListaVeiculos: React.FC = () => {

    const[veiculos, setVeiculos] = useState([] as veiculo[])

    useEffect(() => {
        loadVeiculos()
    },[])

    function loadVeiculos() {
        axios.get(apiUrl+'/veiculos').then(
            response => {
                setVeiculos(response.data as veiculo[])
            }
        )
    }

    return (
        <>
        <Header title='Tinnova' />
        <Container>
            <Row className="mb-3">
                <Col>
                    <Button variant='info'> + Novo veículo</Button>
                </Col>
            </Row>
            <Row>
                <Col lg={12}>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <td>Veículo</td>
                                <td>Marca</td>
                                <td>Ano</td>
                                <td>Cor</td>
                                <td>Descrição</td>
                                <td>Vendido</td>
                                <td>&nbsp;</td>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                veiculos.map(item => (
                                    <tr key={item.id}>
                                        <td>{item.veiculo}</td>
                                        <td>{item.marca}</td>
                                        <td>{item.ano}</td>
                                        <td>{item.cor}</td>
                                        <td>{item.descricao}</td>
                                        <td>{item.vendido? 'Sim' : 'Não'}</td>
                                        <td>
                                            <Button variant="info"><AiFillEdit/> Editar</Button> 
                                            &nbsp;
                                            <Button variant="secondary"><AiFillEdit/> Excluir</Button>
                                        </td>
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

export default ListaVeiculos;
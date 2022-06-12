import React, { useState, useEffect } from 'react';
import { Button, Col, Container, Modal, Row, Table } from 'react-bootstrap';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
import { apiUrl } from '../config';
import 'bootstrap/dist/css/bootstrap.min.css';

import Header from '../components/Header';
import VeiculoTable from '../components/VeiculoTable';

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

    const navigate = useNavigate()
    const[veiculos, setVeiculos] = useState([] as veiculo[])
    const[showDeleteModal, setShowDeleteModal] = useState(false)
    const[deleteId, setDeleteId] = useState(0)

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

    const handleClose = () => setShowDeleteModal(false)

    function deleteVeiculo(id: number) {
        setDeleteId(id)
        setShowDeleteModal(true)
    }

    function deleteVeiculoConfirm() {
        axios.delete(apiUrl+'/veiculos/'+deleteId)
        .then(
            () => loadVeiculos()
        )
        .catch(
            error => {
                console.log(error)
                alert("Erro ao excluir veículo.")
            }
        )
        .finally(
            () => setShowDeleteModal(false)
        )
    }

    function editVeiculo(id: number) {
        navigate('/form/'+id)
    }

    return (
        <>
        <Header title='Tinnova' />
        <Container>
            <Row className="mb-3">
                <Col>
                    <Button variant='info' onClick={() => { navigate('/form')}}>+ Cadastro de veículo</Button>
                </Col>
            </Row>
            <Row>
                <Col lg={12}>
                    <VeiculoTable veiculos={veiculos} onDelete={deleteVeiculo} onEdit={editVeiculo} />
                </Col>
            </Row>
        </Container>
        <Modal show={showDeleteModal} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>Excluir veículo</Modal.Title>
            </Modal.Header>
                    <Modal.Body>Deseja excluir este veículo?</Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={handleClose}>
                    Não
                </Button>
                <Button variant="primary" onClick={deleteVeiculoConfirm}>
                    Sim
                </Button>
            </Modal.Footer>
        </Modal>
        </>
    );
}

export default ListaVeiculos;
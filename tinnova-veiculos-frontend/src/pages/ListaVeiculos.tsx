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

interface ListaVeiculosProps {
    lasWeek?: boolean
}

const ListaVeiculos: React.FC<ListaVeiculosProps> = ( { lasWeek } ) => {

    const navigate = useNavigate()
    const[veiculos, setVeiculos] = useState([] as veiculo[])
    const[showDeleteModal, setShowDeleteModal] = useState(false)
    const[deleteId, setDeleteId] = useState(0)

    const[searchMarca, setSearchMarca] = useState('')
    const[searchAno, setSearchAno] = useState(0)
    const[searchCor, setSearchCor] = useState('')

    useEffect(() => {
        if(lasWeek)
            loadLastWeek()
        else
            loadVeiculos()
    },[])

    function loadVeiculos() {
        axios.get(apiUrl+'/veiculos').then(
            response => {
                setVeiculos(response.data as veiculo[])
            }
        )
        .catch(
            error => {
                console.log(error)
                alert("Erro ao carregar veículos")
            }
        )
    }

    function loadLastWeek() {
        axios.get(apiUrl+'/veiculos').then(
            response => {
                setVeiculos(response.data as veiculo[])
            }
        )
        .catch(
            error => {
                console.log(error)
                alert("Erro ao carregar veículos")
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

    function search(e: React.FormEvent) {
        e.preventDefault()

        let query = "?";

        if(searchMarca.length > 0)
            query += (query.length>1?'&':'')+"marca="+encodeURI(searchMarca)

        if(searchAno > 0)
            query += (query.length>1?'&':'')+"ano="+searchAno

        if(searchCor.length > 0)
            query += (query.length>1?'&':'')+"cor="+encodeURI(searchCor)

        axios.get(apiUrl+'/veiculos'+ query)
        .then(
            response => {
                setVeiculos(response.data as veiculo[])
            }
        )
        .catch(
            error => {
                console.log(error)
                alert("Erro ao carregar veículos")
            }
        )
    }

    function clearSearch() {
        setSearchAno(0)
        setSearchMarca('')
        setSearchCor('')

        loadVeiculos()
    }

    return (
        <>
        <Header title={lasWeek? 'Cadastros da última semana' : 'Lista de veículos'} />
        <Container>
            <Row className="mb-3">
                <Col>
                    <Button variant='info' onClick={() => { navigate('/form')}}>+ Cadastro de veículo</Button>
                </Col>
            </Row>
            <Row>
                <Col className='mt-2 mb-3'>
                    <h5>Pesquisa</h5>
                <form onSubmit={search}>
                    <Row>
                        <Col>
                            <input type="text" value={searchMarca} placeholder="Marca" onChange={(e) => { setSearchMarca(e.target.value)}}/>
                        </Col>
                        <Col>
                            <input type="number" step="1" value={searchAno>0? searchAno : ''} placeholder="Ano" onChange={(e) => { setSearchAno(parseInt(e.target.value))}}/>
                        </Col>
                        <Col>
                            <input type="text" value={searchCor} placeholder="Cor" onChange={(e) => { setSearchCor(e.target.value)}}/>
                        </Col>
                        <Col>
                            <Button variant='info' type='submit'>Buscar</Button> &nbsp;
                            <Button variant='secondar' onClick={clearSearch}>Limpar</Button>
                        </Col>
                    </Row>
                </form>
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
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { Button, Col, Container, Row, ToggleButton } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import Header from '../components/Header';
import { apiUrl } from '../config';

interface veiculo {
    id: number;
    veiculo: string;
    marca: string;
    ano: number;
    cor: string;
    descricao: string;
    vendido: boolean;
}

interface saveVeiculo {
    veiculo: string;
    marca: string;
    ano: number;
    cor: string;
    descricao: string;
    vendido: boolean;
}

const FormVeiculos: React.FC = () => {

    const navigate = useNavigate()
    let { id } = useParams();

    const[veiculo, setVeiculo] = useState('')
    const[marca, setMarca] = useState('')
    const[ano, setAno] = useState(2000)
    const[cor, setCor] = useState('')
    const[descricao, setDescricao] = useState('')
    const[vendido, setVendido] = useState(false)
    const[vId, setVId] = useState(0)

    useEffect(() => {
        if(id)
            loadVeiculo(parseInt(id))
    },[id])

    function save(e: React.FormEvent) {
        e.preventDefault()

        const data = {
            veiculo: veiculo,
            marca: marca,
            ano: ano,
            cor: cor,
            descricao: descricao,
            vendido: vendido
        } as saveVeiculo

        if(vId > 0)
            update(data)
        else
            create(data)
    }

    function create(data: saveVeiculo) {
        axios.post(apiUrl+'/veiculos', data).then(
            response => {
                navigate('/')
            }
        ).catch(
            error => {
                if(error.code === 'ERR_BAD_REQUEST')
                    alert("Verifique se preencheu o nome da marca corretamente")
                else
                    alert("Erro desconhecido")
            }
        )
    }

    function update(data: saveVeiculo) {
        axios.put(apiUrl+'/veiculos/'+vId, data).then(
            response => {
                navigate('/')
            }
        ).catch(
            error => {
                if(error.code === 'ERR_BAD_REQUEST')
                    alert("Verifique se preencheu o nome da marca corretamente")
                else
                    alert("Erro desconhecido")
            }
        )
    }

    function loadVeiculo(id: number) {
        axios.get(apiUrl+'/veiculos/'+id).then(
            response => {
                const data = response.data as veiculo
                setVeiculo(data.veiculo)
                setMarca(data.marca)
                setAno(data.ano)
                setCor(data.cor)
                setDescricao(data.descricao)
                setVendido(data.vendido)
                setVId(data.id)
            }
        ).catch(
            error => {
                alert("Erro ao carregar veículo")
                console.log(error)
            }
        )
    }

    return (
        <>
            <Header title={id? 'Editar veículo' : 'Cadastrar veículo'}/>
            <Container>
                <form action="" onSubmit={(e) => save(e)}>
                    <Row className='mb-3'>
                        <Col>
                            <input type='text' placeholder='Veículo' onChange={(e) => { setVeiculo(e.target.value)}} value={veiculo} required/>
                        </Col>
                        <Col>
                            <input type='text' placeholder='Marca' onChange={(e) => { setMarca(e.target.value)}} value={marca} required/>
                        </Col>
                        <Col>
                            <input type='number' step='1' placeholder='Ano' onChange={(e) => { setAno(parseInt(e.target.value))}} value={ano} required/>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <input type='text' placeholder='Cor' onChange={(e) => { setCor(e.target.value)}} value={cor} required/>
                        </Col>
                        <Col>
                            <input type='text' placeholder='Descrição' onChange={(e) => { setDescricao(e.target.value)}} value={descricao} required/>
                        </Col>
                        <Col>                            
                        <ToggleButton
                            className="mb-2"
                            id="toggle-check"
                            type="checkbox"
                            variant="outline-info"
                            checked={vendido}
                            value="1"
                            onChange={(e) => setVendido(e.currentTarget.checked)}
                        >
                            {vendido? 'Vendido' : 'Em estoque'}
                        </ToggleButton>
                        </Col>
                    </Row>
                    <Row className='mt-3'>
                        <Col>
                            <Button type="submit">Salvar</Button> &nbsp;
                            <Button variant='secondary' onClick={() => { navigate('/')}}>Cancelar</Button>
                        </Col>
                    </Row>
                </form>
            </Container>
        </>
        
    );
}

export default FormVeiculos;
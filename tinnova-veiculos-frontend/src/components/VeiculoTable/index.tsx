import React from 'react';
import { Button, Table } from 'react-bootstrap';
import { AiFillEdit, AiFillDelete } from 'react-icons/ai';

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

interface VeiculoTableProps {
    veiculos: veiculo[];
    onDelete(id: number): void;
    onEdit(id: number): void;
}

const VeiculoTable: React.FC<VeiculoTableProps> = ( { veiculos, onDelete, onEdit } ) => {
    return (
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
                                <Button variant="info" onClick={() => { onEdit(item.id) }}><AiFillEdit/> Editar</Button> 
                                &nbsp;
                                <Button variant="secondary" onClick={() => { onDelete(item.id) }}><AiFillDelete/> Excluir</Button>
                            </td>
                        </tr>
                    ))
                }
            </tbody>
        </Table>
    );
}

export default VeiculoTable;
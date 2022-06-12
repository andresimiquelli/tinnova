import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { apiUrl } from '../../config';

const TotalEstoque: React.FC = () => {

    const[total,setTotal] = useState(0)

    useEffect(() => {
        axios.get(apiUrl+'/veiculos/total/estoque')
        .then(
            response => {
                setTotal(response.data.total)
            }
        )
        .catch(
            error => {
                console.log(error)
                alert("Erro ao carregar estoque")
            }
        )
    },[])

    return (
        <span>
            <h6>{total} <small>não vendidos</small></h6>
        </span>
    );
}

export default TotalEstoque;
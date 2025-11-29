const express = require('express');
const router = express.Router();
const {
    Listar,
    Crear,
    Actualizar,
    Eliminar,
    ListarPedidoByCliente,
    ListarPedidosPorRestaurante,
    ListarPedidosPorCategoriaPlato
} = require('../Controllers/PedidoController');

router.get('/', Listar);
router.get('/cliente/:id', ListarPedidoByCliente);
router.get('/restaurante/:id', ListarPedidosPorRestaurante);
router.get('/cplato/:id', ListarPedidosPorCategoriaPlato);

router.post('/', Crear);
router.put('/:id', Actualizar);
router.delete('/:id', Eliminar);
module.exports = router;


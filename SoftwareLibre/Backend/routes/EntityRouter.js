const express = require('express');
const router = express.Router();
const {
    Listar,
    Crear,
    Eliminar,
    Actualizar,
    Buscar,
    ObtenerPorId,
    ListarPedidoByCliente,
    ListarPedidosPorRestaurante,
    ListarPedidosPorCategoriaPlato
} = require('../Controllers/PedidoController');

// RUTAS CRUD
router.get('/', Listar);
router.get('/:buscar', Buscar);
router.post('/', Crear);
router.put('/:id', Actualizar);
router.delete('/:id', Eliminar);
router.get('/:id', ObtenerPorId);

/*
router.get('/restaurante/:id', ListarPedidosPorRestaurante);
router.get('/cplato/:id', ListarPedidosPorCategoriaPlato);
*/

module.exports = router;
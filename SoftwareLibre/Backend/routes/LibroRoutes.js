const express = require("express");
const router = express.Router();

const {
  Listar,
  Crear,
  Eliminar,
  Actualizar,
  ObtenerPorId,
  Buscar
} = require("../controller/LibroController");

router.get("/", Listar);
router.get("/buscar/:texto", Buscar);
router.get("/:id", ObtenerPorId);
router.post("/", Crear);
router.put("/:id", Actualizar);
router.delete("/:id", Eliminar);

module.exports = router;

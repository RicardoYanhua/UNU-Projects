const express = require("express");
const router = express.Router();

const {
  Listar,
  Crear,
  Eliminar,
  Actualizar,
  ObtenerPorId
} = require("../controller/AutorController");

router.get("/", Listar);
router.get("/:id", ObtenerPorId);
router.post("/", Crear);
router.put("/:id", Actualizar);
router.delete("/:id", Eliminar);

module.exports = router;

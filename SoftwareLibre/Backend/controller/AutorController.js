
const db = require('../config/DataBaseConfig');

const Listar = async (req, res) => {
  const SQL_TABLE_NAME = "autores";
  const SQL_TABLE_PK = "id";
  try {
    const [DB_LISTA] = await db.query(
      "SELECT * FROM " + SQL_TABLE_NAME + " ORDER BY " + SQL_TABLE_PK + " DESC"
    );
    res.json({
      success: true,
      count: DB_LISTA.length,
      data: DB_LISTA,
    });
  } catch (error) {
    res.json({
      success: false,
      mensaje: "Error al obtener los registros.",
      error: error.message,
    });
  }
};

const ObtenerPorId = async (req, res) => {
  const SQL_TABLE_NAME = "autores";
  const SQL_TABLE_PK = "id";
  try {
    const { id } = req.params;
    const [DB_LISTA] = await db.query(
      "SELECT * FROM " + SQL_TABLE_NAME + " WHERE " + SQL_TABLE_PK + " = ?",
      [id]
    );
    if (DB_LISTA.length === 0) {
      return res.status(404).json({
        success: false,
        mensaje: "El registro no fue encontrado o no existe.",
      });
    }
    res.json({
      success: true,
      mensaje: "Registro Encontrado.",
      data: DB_LISTA[0],
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      mensaje: "Error al obtener el registro.",
      error: error.message,
    });
  }
};

const Crear = async (req, res) => {
  const SQL_TABLE_NAME = "autores";
  try {
    //JSON
    const { 
        nombres, 
        apellidos
        } 
        = req.body;
    // VALIDACIONES
    if (!nombres || !apellidos) {
      return res.status(400).json({
        success: true,
        mensaje: "Campos obligatorios, no puede estar vacio.",
      });
    }
    // CREACION DEL REGISTRO
    const [CREATED] = await db.query(
      " INSERT INTO " +
        SQL_TABLE_NAME +
        " ( " +
        " nombres, " +
        " apellidos " +
        " ) " +
        " VALUES (?,?) ",
      [nombres, apellidos]
    );
    res.status(201).json({
      success: true,
      mensaje: "Se ha creado un nuevo registro exitosamente.",
      data: {
        id: CREATED.insertId,
        nombres,
        apellidos
      },
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      mensaje: "Error al crear el registro.",
      error: error.message,
    });
  }
};

const Actualizar = async (req, res) => {
  const SQL_TABLE_NAME = "autores";
  const SQL_TABLE_PK = "id";
  try {
    const { id } = req.params;
    const { 
        nombres, 
        apellidos
        } 
        = req.body;
    // VERIFICAMOS SI EXISTE
    const [EXIST] = await db.query(
      "SELECT * FROM " + SQL_TABLE_NAME + " WHERE " + SQL_TABLE_PK + " = ?",
      [id]
    );
    if (EXIST.length === 0) {
      return res.status(404).json({
        success: false,
        mensaje: "El registro no fue encontrado o no existe.",
      });
    }
    // ACTUALIZAMOS REGISTRO
    await db.query(
      " UPDATE " +
        SQL_TABLE_NAME +
        " SET " +
        " nombres = ?, " +
        " apellidos = ? " +
        " WHERE " + SQL_TABLE_PK + " = ?",
      [nombres, apellidos, id]
    );
    res.status(201).json({
      success: true,
      mensaje: "Registro actualizado exitosamente.",
      data: {
        id,
        nombres,
        apellidos
      },
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      mensaje: "Error al actualizar el registro.",
      error: error.message,
    });
  }
};

const Eliminar = async (req, res) => {
  const SQL_TABLE_NAME = "autores";
  const SQL_TABLE_PK = "id";
  try {
    const { id } = req.params;
    // VERIFICAMOS SI EXISTE
    const [EXIST] = await db.query(
      "SELECT * FROM " + SQL_TABLE_NAME + " WHERE " + SQL_TABLE_PK + " = ?",
      [id]
    );
    if (EXIST.length === 0) {
      return res.status(404).json({
        success: false,
        mensaje: "El registro no fue encontrado o no existe.",
      });
    }
    // ELIMINAMOS EL REGISTRO
    await db.query("DELETE FROM " + SQL_TABLE_NAME + " WHERE " + SQL_TABLE_PK + " = ?", [id]);
    res.status(201).json({
      success: true,
      mensaje: "Se ha eliminado el registro correctamente.",
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      mensaje: "Error al eliminar el registro.",
      error: error.message,
    });
  }
};

const Buscar = async (req, res) => {
  const SQL_TABLE_NAME = "autores";
  const SQL_TABLE_PK = "id";
  const SQL_TABLE_VAR_SEARCH = "nombres";
  try {
    const { buscar } = req.query;
    if (!buscar) {
      return res.status(400).json({
        success: false,
        mensaje: "Debe proporcionar un texto para realizar la búsqueda.",
      });
    }
    const [BUSQUEDA] = await db.query(
      "SELECT * FROM " + SQL_TABLE_NAME + " WHERE " + SQL_TABLE_VAR_SEARCH + " LIKE ? ORDER BY " + SQL_TABLE_PK + " DESC ",
      ["%" + buscar + "%"]
    );
    if (BUSQUEDA.length === 0) {
      return res.status(404).json({
        success: false,
        mensaje:
          "No se encontraron registros con el texto de busqueda insertado.",
      });
    }
    res.json({
      success: true,
      mensaje: "Búsqueda realizada correctamente.",
      count: BUSQUEDA.length,
      data: BUSQUEDA
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      mensaje: "Error al realizar la búsqueda.",
      error: error.message,
    });
  }
};

module.exports = {
    Listar,
    Crear,
    Eliminar,
    Actualizar,
    Buscar,
    ObtenerPorId
}

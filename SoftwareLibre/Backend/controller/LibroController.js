const db = require("../config/DataBaseConfig");

const Listar = async (req, res) => {
  const SQL_TABLE_NAME = "libros";
  const SQL_TABLE_PK = "id";
  try {
    const [DB_LISTA] = await db.query(
      "SELECT * FROM " + SQL_TABLE_NAME + " ORDER BY " + SQL_TABLE_PK + " DESC"
    );
    const [DB_LISTA_2] = await db.query(
      " SELECT " +
        " l.id, " +
        " l.titulo, " +
        " l.isbn, " +
        " l.editorial, " +
        " l.anioPublicacion, " +
        " l.idAutor, " +
        " a.nombres AS autorNombre, " +
        " l.idCategoria, " +
        " c.nombre AS categoriaNombre " +
        " FROM libros l " +
        " LEFT JOIN autores a ON l.idAutor = a.id " +
        " LEFT JOIN categorias c ON l.idCategoria = c.id " +
        " ORDER BY l.id DESC; "
    );
    res.json({
      success: true,
      count: DB_LISTA_2.length,
      data: DB_LISTA_2,
    });
  } catch (error) {
    res.json({
      success: false,
      mensaje: "Error al obtener los registros.",
      error: error.message,
    });
  }
};

const Buscar = async (req, res) => {
  const SQL_TABLE_NAME = "libros";
  const SQL_TABLE_PK = "id";
  const SQL_TABLE_VAR_SEARCH = "titulo";
  try {
    const { texto } = req.params;
    if (!texto) {
      return res.status(400).json({
        success: false,
        mensaje: "Debe proporcionar un texto para realizar la búsqueda.",
      });
    }
    const [BUSQUEDA] = await db.query(
      " SELECT " +
        " l.id, " +
        " l.titulo, " +
        " l.isbn, " +
        " l.editorial, " +
        " l.anioPublicacion, " +
        " l.idAutor, " +
        " a.nombres AS autorNombre, " +
        " l.idCategoria, " +
        " c.nombre AS categoriaNombre " +
        " FROM " + SQL_TABLE_NAME + " l " +
        " LEFT JOIN autores a ON l.idAutor = a.id " +
        " LEFT JOIN categorias c ON l.idCategoria = c.id " +
        " WHERE " + SQL_TABLE_VAR_SEARCH +
        " LIKE ? ORDER BY " + SQL_TABLE_PK + " DESC ",
      [texto + "%"]
    );
    res.json({
      success: true,
      mensaje: "Búsqueda realizada correctamente.",
      count: BUSQUEDA.length,
      data: BUSQUEDA,
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      mensaje: "Error al realizar la búsqueda.",
      error: error.message,
    });
  }
};

const ObtenerPorId = async (req, res) => {
  const SQL_TABLE_NAME = "libros";
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
  const SQL_TABLE_NAME = "libros";
  try {
    //JSON
    const { titulo, idAutor, isbn, editorial, anioPublicacion, idCategoria } =
      req.body;
    // VALIDACIONES
    if (!titulo) {
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
        " titulo, " +
        " idAutor, " +
        " isbn,  " +
        " editorial,  " +
        " anioPublicacion,  " +
        " idCategoria  " +
        " ) " +
        " VALUES (?,?,?,?,?,?) ",
      [titulo, idAutor, isbn, editorial, anioPublicacion, idCategoria]
    );
    res.status(201).json({
      success: true,
      mensaje: "Se ha creado un nuevo registro exitosamente.",
      data: {
        id: CREATED.insertId,
        titulo,
        idAutor,
        isbn,
        editorial,
        anioPublicacion,
        idCategoria,
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
  const SQL_TABLE_NAME = "libros";
  const SQL_TABLE_PK = "id";
  try {
    const { id } = req.params;
    const { titulo, idAutor, isbn, editorial, anioPublicacion, idCategoria } =
      req.body;
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
        " titulo = ?, " +
        " idAutor = ?, " +
        " isbn = ?, " +
        " editorial = ?, " +
        " anioPublicacion = ?, " +
        " idCategoria = ?  " +
        " WHERE " +
        SQL_TABLE_PK +
        " = ?",
      [titulo, idAutor, isbn, editorial, anioPublicacion, idCategoria, id]
    );
    res.status(201).json({
      success: true,
      mensaje: "Registro actualizado exitosamente.",
      data: {
        id,
        titulo,
        idAutor,
        isbn,
        editorial,
        anioPublicacion,
        idCategoria,
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
  const SQL_TABLE_NAME = "libros";
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
    await db.query(
      "DELETE FROM " + SQL_TABLE_NAME + " WHERE " + SQL_TABLE_PK + " = ?",
      [id]
    );
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

module.exports = {
  Listar,
  Crear,
  Eliminar,
  Actualizar,
  ObtenerPorId,
  Buscar,
};

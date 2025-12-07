export interface Libro {
    id?: number;
    titulo: string;

    idAutor: number;
    autorNombre?: string;

    isbn: string;
    editorial: string;
    anioPublicacion: number;
    
    idCategoria: number;
    categoriaNombre?: string;
}

export interface LibroResponse {
    success: boolean;
    data?: Libro | Libro[];
    count?: number;
    mensaje?: string;
    error?: string;
}

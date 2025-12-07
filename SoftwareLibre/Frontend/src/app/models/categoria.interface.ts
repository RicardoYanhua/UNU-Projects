export interface Categoria {
    id?: number;
    nombre: string;
    
}

export interface CategoriaResponse {
    success: boolean;
    data?: Categoria | Categoria[];
    count?: number;
    mensaje?: string;
    error?: string;
}

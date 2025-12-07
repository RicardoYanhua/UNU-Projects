export interface Entity {
    id?: number;
    titulo: string;
    autor: number;
    isbn: string;
    editorial: string;
    idCategoria: number;
}
export interface EntityResponse {
    success: boolean;
    data?: Entity | Entity[];
    count?: number;
    mensaje?: string;
    error?: string;
}

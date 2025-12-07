export interface Autor {
    id?: number;
    nombres: string;
    apellidos: string;
}
export interface AutorResponse {
    success: boolean;
    data?: Autor | Autor[];
    count?: number;
    mensaje?: string;
    error?: string;
}

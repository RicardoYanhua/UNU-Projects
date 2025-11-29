

export interface Pedido { 
    codigo?: number,
    fecha: string,
            horafecha: string,
            id_estado: number,
            metodo_pago: string,
            total: number,
            observacionfecha: string,
            id_clientefecha: number,
            id_mesero: number
}

export interface PedidoResponse{
    success : boolean;
    data?: Pedido | Pedido[];
    count?: number;
    mensaje?: string;
    error?: string;
}
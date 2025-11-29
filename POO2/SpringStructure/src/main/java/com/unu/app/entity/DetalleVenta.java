package com.unu.app.entity;

import jakarta.persistence.*;

	@Entity
	@Table(name = "detalle_venta")
	public class DetalleVenta {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	
	    @ManyToOne
	    @JoinColumn(name = "venta_id", nullable = false)
	    private Venta venta;
	
	    @ManyToOne
	    @JoinColumn(name = "producto_id", nullable = false)
	    private Producto producto;
	
	    @Column(name = "cantidad", nullable = false)
	    private Integer cantidad;
	
	    @Column(name = "total", nullable = false)
	    private Double total;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Venta getVenta() {
			return venta;
		}

		public void setVenta(Venta venta) {
			this.venta = venta;
		}

		public Producto getProducto() {
			return producto;
		}

		public void setProducto(Producto producto) {
			this.producto = producto;
		}

		public Integer getCantidad() {
			return cantidad;
		}

		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}

		public Double getTotal() {
			return total;
		}

		public void setTotal(Double total) {
			this.total = total;
		}
	    
	    
	}
package com.deiz0ndev.curso.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.deiz0ndev.curso.entidades.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;
	
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Usuario cliente; 
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemsPedido> items = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Pedido() {
	}

	public Pedido(Long id, Instant momento, StatusPedido status,Usuario cliente) {
		super();
		this.id = id;
		this.momento = momento;
		setStatus(status);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public Instant getMomento() {
		return momento;
	}
	
	public StatusPedido getStatus() {
		return StatusPedido.valueOf(status);
	}
	
	public void setStatus(StatusPedido status) {
		if (status != null) {
			this.status = status.getCodigo();
		}
	}
	
	public Usuario getCliente() {
		return cliente;
	}
	
	public Set<ItemsPedido> getItems() {
		return items;
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}
	
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Double getTotal() {
		double soma = 0.0;
		for (ItemsPedido x : items) {
			soma += x.getValorTotal();
		}
		return soma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", momento=" + momento + "]";
	}
	
}

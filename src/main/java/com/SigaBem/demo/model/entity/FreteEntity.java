package com.SigaBem.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblFrete")
@Entity
public class FreteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "cep_origem")
    private String cepOrigem;

    @Column(name = "cep_destino")
    private String cepDestino;

    @Column(name = "nome_destinatario")
    private String nomeDestinatario;

    @Column(name = "vl_totalFrete")
    private BigDecimal vlTotalFrete;

    @Column(name = "data_previstaEntrega")
    private Integer dataPrevistaEntrega;

    @Column(name = "data_Consulta")
    @CreatedDate
    private LocalDateTime dataConsulta;

}

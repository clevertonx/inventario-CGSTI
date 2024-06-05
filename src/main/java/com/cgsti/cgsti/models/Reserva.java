    package com.cgsti.cgsti.models;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.time.LocalDate;
    import java.util.List;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Reserva {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String responsavelSetor;
        private LocalDate dataSolicitacao;
        private LocalDate dataRetirada;
        private LocalDate dataEntrega;
        private LocalDate dataDevolucao;

        @Enumerated(EnumType.STRING)
        private Periodo periodo;
        @Enumerated(EnumType.STRING)
        private StatusReserva statusReserva;
        private String localEvento;
        private String telefone;


        @OneToMany(mappedBy = "reserva", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        private List<Equipamento> equipamentos;

        public Reserva(String responsavelSetor, LocalDate dataSolicitacao, LocalDate dataRetirada, LocalDate dataEntrega, LocalDate dataDevolucao,
                       Periodo periodo,StatusReserva statusReserva, String localEvento, String telefone, List<Equipamento> equipamentos) {
            this.responsavelSetor = responsavelSetor;
            this.dataSolicitacao = dataSolicitacao;
            this.dataRetirada = dataRetirada;
            this.dataEntrega = dataEntrega;
            this.dataDevolucao = dataDevolucao;
            this.periodo = periodo;
            this.statusReserva = statusReserva;
            this.localEvento = localEvento;
            this.telefone = telefone;
            this.equipamentos = equipamentos;

            if (equipamentos != null) {
                for (Equipamento equipamento : equipamentos) {
                    equipamento.setReserva(this);
                }
            }
        }
    }

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// MODELO: Cliente
class Cliente {
    private String nome;
    private Date aniversario;
    private String whatsapp;
    private String enderecoRua;
    private int enderecoNumero;
    private String bairro;
    private String complemento;

    public Cliente(String nome, Date aniversario, String whatsapp, String enderecoRua, int enderecoNumero, String bairro, String complemento) {
        this.nome = nome;
        this.aniversario = aniversario;
        this.whatsapp = whatsapp;
        this.enderecoRua = enderecoRua;
        this.enderecoNumero = enderecoNumero;
        this.bairro = bairro;
        this.complemento = complemento;
    }

    // Método getter para o nome
    public String getNome() {
        return nome;
    }

    // Outros getters e setters podem ser adicionados aqui
}

// MODELO: Produto
class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e setters
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
}

// MODELO: Pedido
class Pedido {
    private Date data;
    private Cliente cliente;
    List<Produto> produtos;
        int ordemDeChegada;
            String formaEntrega;
                        private String formaPagamento;
                        private boolean entregaConfirmada;
                    
                        public Pedido(Cliente cliente, List<Produto> produtos, int ordemDeChegada, String formaEntrega, String formaPagamento) {
                            this.data = new Date();
                            this.cliente = cliente;
                            this.produtos = produtos;
                            this.ordemDeChegada = ordemDeChegada;
                            this.formaEntrega = formaEntrega;
                            this.formaPagamento = formaPagamento;
                            this.entregaConfirmada = false;
                        }
                    
                        public void confirmarEntrega() {
                            this.entregaConfirmada = true;
                        }
                    
                        // Getters e setters
                        public Cliente getCliente() {
                            return cliente;
                        }
                    }
                    
                    // CONTROLLER: PedidoController
                    class PedidoController {
                        private List<Pedido> pedidos;
                    
                        public PedidoController() {
                            pedidos = new ArrayList<>();
                        }
                    
                        public void registrarPedido(Pedido pedido) {
                            pedidos.add(pedido);
                            System.out.println("Pedido registrado com sucesso!");
                        }
                    
                        public void imprimirPedido(Pedido pedido) {
                            System.out.println("Detalhes do Pedido:");
                            System.out.println("Cliente: " + pedido.getCliente().getNome());
                            System.out.println("Produtos: ");
                            for (Produto produto : pedido.produtos) {
                            System.out.println("- " + produto.getNome() + " - R$ " + produto.getPreco());
                        }
                        System.out.println("Forma de Entrega: " + pedido.formaEntrega);
        }
    
        // Método para gerar um resumo diário
        public void gerarResumoDiario() {
            System.out.println("Resumo diario de pedidos:");
            for (Pedido pedido : pedidos) {
                System.out.println("Pedido #" + pedido.ordemDeChegada + " - Cliente: " + pedido.getCliente().getNome());
        }
    }
}

// VIEW: Interface do sistema
public class RestauranteApp {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Maria Silva", new Date(), "123456789", "Rua das Flores", 100, "Centro", "Apto 101");
        Produto marmitaCompleta = new Produto("Marmita Completa", 20.0);
        Produto refri = new Produto("Refrigerante", 5.0);

        List<Produto> produtos = new ArrayList<>();
        produtos.add(marmitaCompleta);
        produtos.add(refri);

        Pedido pedido1 = new Pedido(cliente1, produtos, 1, "Delivery", "Pix");
        
        PedidoController pedidoController = new PedidoController();
        pedidoController.registrarPedido(pedido1);
        pedidoController.imprimirPedido(pedido1);
        pedidoController.gerarResumoDiario();
    }
}

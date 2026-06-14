// Interface comum utilizada pelo Proxy e pelo Objeto Base.
// O cliente conhece apenas esta interface.
interface BancoDeDadosRH {
    String visualizarSalario(String nomeFuncionario);
}


// OBJETO BASE (Real Subject)
// Classe responsável pelo acesso real aos dados do RH.
// Contém a lógica verdadeira e os dados sensíveis.
class BancoDeDadosRHReal implements BancoDeDadosRH {

    @Override
    public String visualizarSalario(String nomeFuncionario) {
        return "Salário de " + nomeFuncionario + ": R$ 6.000,00";
    }
}

// PROXY
// Atua como intermediário entre o cliente e o objeto base.
// Seu papel é controlar o acesso aos dados do RH,
// verificando se o usuário possui permissão.
class ProxyBancoDeDadosRH implements BancoDeDadosRH {

    private BancoDeDadosRHReal bancoReal;
    private String cargoUsuarioLogado;

    public ProxyBancoDeDadosRH(String cargoUsuarioLogado) {
        this.cargoUsuarioLogado = cargoUsuarioLogado;
    }

    @Override
    public String visualizarSalario(String nomeFuncionario) {

        // O Proxy verifica a permissão ANTES de acessar
        // o objeto base.
        if ("Gerente".equalsIgnoreCase(cargoUsuarioLogado)) {

            // Instanciação sob demanda (Lazy Initialization)
            if (bancoReal == null) {
                bancoReal = new BancoDeDadosRHReal();
            }

            System.out.println("[Proxy] Acesso liberado.");
            return bancoReal.visualizarSalario(nomeFuncionario);
        }

        return "[Proxy] Acesso negado. Você não possui permissão.";
    }
}


// CLIENTE
// O cliente nunca acessa o BancoDeDadosRHReal diretamente.
// Toda comunicação é feita através do Proxy.
public class MainQuestao4 {

    public static void main(String[] args) {

        // Cliente: usuário com perfil de estagiário
        BancoDeDadosRH proxyEstagiario =
                new ProxyBancoDeDadosRH("Estagiario");

        System.out.println("ESTAGIÁRIO:");
        System.out.println(
                proxyEstagiario.visualizarSalario("João")
        );

        System.out.println("---");

        // Cliente: usuário com perfil de gerente
        BancoDeDadosRH proxyGerente =
                new ProxyBancoDeDadosRH("Gerente");

        System.out.println("GERENTE:");
        System.out.println(
                proxyGerente.visualizarSalario("João")
        );
    }
}
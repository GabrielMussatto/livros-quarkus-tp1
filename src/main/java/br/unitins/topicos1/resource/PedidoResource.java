package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;
import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.dto.CartaoCreditoDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.model.Pessoa.Cliente;
import br.unitins.topicos1.repository.pessoa.ClienteRepository;
import br.unitins.topicos1.service.ClienteService;
import br.unitins.topicos1.service.PedidoService;
import br.unitins.topicos1.validation.ValidationException;
//import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/pedidos")
public class PedidoResource {

    @Inject
    public PedidoService pedidoservice;

    @Inject
    public ClienteService clienteservice;

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    JsonWebToken tokenJwt;

    private static final Logger LOG = Logger.getLogger(PedidoResource.class);

    @GET
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id") Long id){
        LOG.info("Buscando com id - Executando PedidoResource_FindById");
        return Response.ok(pedidoservice.findById(id)).build();
    }

    @GET
    //@RolesAllowed({"Funcionario"})
    public Response findAll(){
        LOG.info("Buscando todos os pedidos - Executando PedidoResource_FindAll");
        return Response.ok(pedidoservice.findAll()).build();
    }

    @GET
    @Path("/search/clientes/{idCliente}")
    //@RolesAllowed({"Funcionario"})
    public Response findByCliente(@PathParam("idCliente") Long idCliente){
        LOG.info("Buscando com id do cliente - Executando PedidoResource_FindByCliente");
        return Response.ok(pedidoservice.findByCliente(idCliente)).build();
    }

    @POST
    //@RolesAllowed({"Cliente"})
    public Response create(@Valid PedidoDTO dto) {

        try{
            String username = tokenJwt.getName();

            if(!pedidoservice.clienteAutenticado(username, dto.idCliente()))
                throw new ValidationException("Valificando cliente para criacao de pedido", "você não tem permissão para realizar pedido. - Executando PedidoResource_create");
                
            LOG.info("Executando PedidoResource_create");
            return Response.status(Status.CREATED).entity(pedidoservice.create(dto)).build();
        }catch (Exception e){
            LOG.error("Erro ao criar pedido - Executando PedidoResource_create", e);
            return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/search/cancelar-Pedido")
    //@RolesAllowed({"Cliente"})
    public Response cancelarPedido() {

        try {
            String username = tokenJwt.getName();
            Cliente cliente = clienteRepository.findByUsername(username);

            if(!pedidoservice.clienteAutenticado(username, cliente.getId()))
                throw new ValidationException("Validando cliente para cancelamento de pedido", "Você não tem permissão para cancelar pedido. - Executando PedidoResource_cancelarPedido");
        
            pedidoservice.cancelarPedido(cliente.getId());
            LOG.info("Pedido cancelada com sucesso. - Executando PedidoResource_cancelarPedido");
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao cancelar compra. - Executando PedidoResource_cancelarPedido", e);
            return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/search/meus-Pedidos")
    //@RolesAllowed({"Funcionario","Cliente"})
    public Response meusPedidos(){
        try {
            LOG.info("Meus Pedido. - Executando PedidoResource_meusPedidos");
            String username = tokenJwt.getName();
            Cliente cliente = clienteRepository.findByUsername(username);

            if(!pedidoservice.clienteAutenticado(username, cliente.getId()))
                throw new ValidationException("Validando cliente para visualiar pedidos", "Você não tem permissão para vê os pedidos - Executando PedidoResource_meusPedidos");

            return Response.ok(pedidoservice.meusPedidos()).build();
        } catch (NotFoundException e) {
            LOG.error("Erro ao visualizar meus pedidos - Executando PedidoResource_meusPedidos", e);
            return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @PATCH
    @Path("/search/pagar-Boleto")
    //@RolesAllowed({"Cliente"})
    public Response pagarBoleto() {

        try {
            
            String username = tokenJwt.getName();
            Cliente cliente = clienteRepository.findByUsername(username);

            if(!pedidoservice.clienteAutenticado(username, cliente.getId()))
                 throw new ValidationException("ValidandoPagamento", "Você não tem permissão para realizar pagamento via boleto de pedido. - Executando PedidoResource_pagarBoleto");
        
            pedidoservice.pagamentoBoleto(cliente.getId());

            LOG.info("Pagamento com boleto realizado com sucesso. - Executando PedidoResource_pagarBoleto");
            return Response.status(Status.ACCEPTED).build();
        } catch (Exception e) {
            LOG.error("Erro ao realizar pagamento com boleto - Executando PedidoResource_pagarBoleto");
            return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @PATCH
    @Path("/search/pagar-Pix")
    //@RolesAllowed({"Cliente"})
    public Response pagarPix() {
        try {
            String username = tokenJwt.getName();
            Cliente cliente = clienteRepository.findByUsername(username);
    
            if(!pedidoservice.clienteAutenticado(username, cliente.getId()))
                throw new ValidationException("ValidandoPagamento", "Você não tem permissão para realizar pagamento via pix de pedido. - Executando PedidoResource_pagarPix");
            

            pedidoservice.pagamentoPix(cliente.getId());

            LOG.info("Pagamento do pix realizado com sucesso. - Executando PedidoResource_pagarPix");
            return Response.status(Status.ACCEPTED).build();
        } catch (Exception e) {
            LOG.error("Erro ao realizar pagamento com pix - Executando PedidoResource_pagarPix");
            return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @PATCH
    @Path("/search/pagar-Cartao-Credito")
    //@RolesAllowed({"Cliente"})
    public Response pagarCartaoCredito(CartaoCreditoDTO cartao) {
        try {
            String username = tokenJwt.getSubject();
            Cliente cliente = clienteRepository.findByUsername(username);
    
            if(!pedidoservice.clienteAutenticado(username, cliente.getId()))
                throw new ValidationException("ValidandoPagamento", "Você não tem permissão para realizar pagamento via pix de pedido. - Executando PedidoResource_pagarCartaoCredito");
            
            pedidoservice.pagamentoCartao(cliente.getId(), cartao);

            LOG.info("Pagamento com cartão realizado com sucesso. - Executando PedidoResource_pagarCartaoCredito");
            return Response.status(Status.ACCEPTED).build();
        } catch (Exception e) {
            LOG.error("Erro ao realizar pagamento com cartao de credito - Executando PedidoResource_pagarCartaoCredito");
            return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}

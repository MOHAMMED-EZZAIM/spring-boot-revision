package usa.harvard.tp1_commande.ws.convertie;

import org.springframework.stereotype.Component;
import usa.harvard.tp1_commande.bean.TypePaiement;
import usa.harvard.tp1_commande.ws.dto.TypePaiementDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypePaiementConverter {
    public TypePaiementDto toDto(TypePaiement bean){
        TypePaiementDto dto=new TypePaiementDto();
        dto.setCode(bean.getCode());
        dto.setLibelle(bean.getLibelle());
       return  dto;
    }
    public TypePaiement toBean(TypePaiementDto dto){
        TypePaiement bean=new TypePaiement();
        bean.setCode(dto.getCode());
        bean.setLibelle(dto.getLibelle());
        return  bean;
    }
    public List<TypePaiement> toBean(List<TypePaiementDto> dtos){
        List<TypePaiement> beans=new ArrayList<>();
        dtos.forEach(type->{
            beans.add(toBean(type));
        });
        return beans;
    }
    public  List<TypePaiementDto> toDto(List<TypePaiement> beans){
        List<TypePaiementDto> dtos=new ArrayList<>();
        beans.forEach(bean->{
            dtos.add(toDto(bean));
        });
        return dtos;
    }
}

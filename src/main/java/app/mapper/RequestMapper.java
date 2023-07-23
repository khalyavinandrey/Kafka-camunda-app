package app.mapper;


import app.dto.RequestDto;
import app.model.Request;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface RequestMapper {

    @Mapping(target = "key", source = "key")
    @Mapping(target = "message", source = "payload.message")
    Request toEntity(RequestDto requestDto);

    RequestDto toDto(Request request);
}

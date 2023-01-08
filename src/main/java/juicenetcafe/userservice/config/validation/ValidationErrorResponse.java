package juicenetcafe.userservice.config.validation;

import juicenetcafe.userservice.config.validation.ErrorModel;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
public class ValidationErrorResponse {
    private final List<ErrorModel> errors = new ArrayList<>();
}

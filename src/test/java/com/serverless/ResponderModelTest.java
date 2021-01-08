package com.serverless;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponderModelTest {

    ResponderModel responderModel = new ResponderModel();

    @Test
    public void cuandoPreguntaWhatIsYourName (){
        String pregunta = ".*what is your name";
        String respuesta = responderModel.answer(pregunta);
        assertThat(respuesta).isEqualTo("Jovenes En Accion");
    }


}

/*
 * Copyright(c) 2021 Hemajoo Digital Systems Inc.
 * --------------------------------------------------------------------------------------
 * This file is part of Hemajoo Systems Inc. projects which is licensed
 * under the Apache license version 2 and use is subject to license terms.
 * You should have received a copy of the license with the project's artifact
 * binaries and/or sources.
 *
 * License can be consulted at http://www.apache.org/licenses/LICENSE-2.0
 * --------------------------------------------------------------------------------------
 */
package com.hemajoo.commerce.cherry.persistence.model.entity.document;

import com.hemajoo.commerce.cherry.model.entity.document.Document;
import com.hemajoo.commerce.cherry.model.entity.document.DocumentType;
import com.hemajoo.commerce.cherry.persistence.base.randomizer.BaseEntityRandomizer;
import lombok.experimental.UtilityClass;
import org.ressec.avocado.core.random.EnumRandomGenerator;

import java.util.Random;
import java.util.UUID;

/**
 * Document generator.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@UtilityClass
public final class DocumentRandomizer extends BaseEntityRandomizer
{
    /**
     * Document type enumeration generator.
     */
    private static final EnumRandomGenerator DOCUMENT_TYPE_GENERATOR = new EnumRandomGenerator(DocumentType.class).exclude(DocumentType.UNSPECIFIED);

    /**
     * Generates a new random persistent document.
     * @return Random document.
     */
    public static DocumentEntity generatePersistent()
    {
        var entity = new DocumentEntity();
        BaseEntityRandomizer.populateBaseFields(entity);

        entity.setName(FAKER.name().title());
        entity.setContentPath(FAKER.funnyName().name());
        entity.setExtension(FAKER.file().extension());
        entity.setContentId(UUID.randomUUID().toString());
        entity.setContentLength(new Random().nextLong());
        entity.setMimeType(FAKER.file().mimeType());
        entity.setTags(FAKER.elderScrolls().creature());
        entity.setDocumentType((DocumentType) DOCUMENT_TYPE_GENERATOR.gen());

        return entity;
    }

    /**
     * Generates a new random client document.
     * @return Random document.
     */
    public static Document generateClient()
    {
        var entity = new Document();
        BaseEntityRandomizer.populateBaseFields(entity);

        entity.setName(FAKER.name().title());
        entity.setContentPath(FAKER.funnyName().name());
        entity.setExtension(FAKER.file().extension());
        entity.setContentId(UUID.randomUUID().toString());
        entity.setContentLength(new Random().nextLong());
        entity.setMimeType(FAKER.file().mimeType());
        entity.setTags(FAKER.elderScrolls().creature());
        entity.setDocumentType((DocumentType) DOCUMENT_TYPE_GENERATOR.gen());

        return entity;
    }
}

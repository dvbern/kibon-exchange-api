/*
 * Copyright (C) 2019 DV Bern AG, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ch.dvbern.kibon.exchange.api.verfuegung.model.fileexport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FileExportDTO implements Serializable {

	private static final long serialVersionUID = -5782035964234678821L;

	@Nonnull
	private static final String SCHEMA_VERSION = "2.0";

	@Nonnull
	private @Size(min = 1) @NotNull String schemaVersion = SCHEMA_VERSION;

	@Nonnull
	private @NotNull @Valid List<FileVerfuegungDTO> verfuegungen = new ArrayList<>();

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		FileExportDTO that = (FileExportDTO) o;

		return getSchemaVersion().equals(that.getSchemaVersion()) &&
			getVerfuegungen().equals(that.getVerfuegungen());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSchemaVersion(), getVerfuegungen());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", FileExportDTO.class.getSimpleName() + '[', "]")
			.add("schemaVersion='" + schemaVersion + '\'')
			.toString();
	}

	@Nonnull
	public String getSchemaVersion() {
		return schemaVersion;
	}

	public void setSchemaVersion(@Nonnull String schemaVersion) {
		this.schemaVersion = schemaVersion;
	}

	@Nonnull
	public List<FileVerfuegungDTO> getVerfuegungen() {
		return verfuegungen;
	}

	public void setVerfuegungen(@Nonnull List<FileVerfuegungDTO> verfuegungen) {
		this.verfuegungen = verfuegungen;
	}
}

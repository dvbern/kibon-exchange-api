/*
 * Copyright (C) 2022 DV Bern AG, Switzerland
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

package ch.dvbern.kibon.exchange.api.common.dashboard.gemeinde;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class GemeindeDTO implements Serializable {

	private static final long serialVersionUID = 1939750203537206169L;

	@Schema(description = "Strikt monoton steigende ID\n\n"
		+ "Kann für Filterung mit dem `after_id` Parameter verwendet werden.")
	@Nonnull
	private @NotNull Long sequenceId;

	@Nonnull
	private @NotNull String name;

	@Nonnull
	private @NotNull LocalDate betreuungsgutscheineAnbietenAb;

	@Nonnull
	private @NotNull LocalDate gueltigBis;

	@Nonnull
	private @NotNull Long bfsNummer;

	public GemeindeDTO() {
		this.sequenceId = 0L;
		this.name = "";
		this.betreuungsgutscheineAnbietenAb = LocalDate.MIN;
		this.gueltigBis = LocalDate.MAX;
		this.bfsNummer = 0L;
	}

	public GemeindeDTO(
		@Nonnull Long sequenceId,
		@Nonnull String name,
		@Nonnull LocalDate betreuungsgutscheineAnbietenAb,
		@Nonnull LocalDate gueltigBis,
		@Nonnull Long bfsNummer) {
		this.sequenceId = sequenceId;
		this.name = name;
		this.betreuungsgutscheineAnbietenAb = betreuungsgutscheineAnbietenAb;
		this.gueltigBis = gueltigBis;
		this.bfsNummer = bfsNummer;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		GemeindeDTO that = (GemeindeDTO) o;

		return getSequenceId().equals(that.getSequenceId())
			&& getName().equals(that.getName())
			&& getBetreuungsgutscheineAnbietenAb().equals(that.getBetreuungsgutscheineAnbietenAb())
			&& getGueltigBis().equals(that.getGueltigBis())
			&& getBfsNummer().equals(that.getBfsNummer());
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getSequenceId(),
			getName(),
			getBetreuungsgutscheineAnbietenAb(),
			getGueltigBis(),
			getBfsNummer());
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", GemeindeDTO.class.getSimpleName() + '[', "]")
			.add("sequenceId=" + sequenceId)
			.add("name=" + name)
			.add("betreuungsgutscheineAnbietenAb=" + betreuungsgutscheineAnbietenAb)
			.add("gueltigBis=" + gueltigBis)
			.add("bfsNummer=" + bfsNummer)
			.toString();
	}

	@Nonnull
	public Long getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(@Nonnull Long sequenceId) {
		this.sequenceId = sequenceId;
	}

	@Nonnull
	public String getName() {
		return name;
	}

	public void setName(@Nonnull String name) {
		this.name = name;
	}

	@Nonnull
	public LocalDate getBetreuungsgutscheineAnbietenAb() {
		return betreuungsgutscheineAnbietenAb;
	}

	public void setBetreuungsgutscheineAnbietenAb(@Nonnull LocalDate betreuungsgutscheineAnbietenAb) {
		this.betreuungsgutscheineAnbietenAb = betreuungsgutscheineAnbietenAb;
	}

	@Nonnull
	public LocalDate getGueltigBis() {
		return gueltigBis;
	}

	public void setGueltigBis(@Nonnull LocalDate gueltigBis) {
		this.gueltigBis = gueltigBis;
	}

	@Nonnull
	public Long getBfsNummer() {
		return bfsNummer;
	}

	public void setBfsNummer(@Nonnull Long bfsNummer) {
		this.bfsNummer = bfsNummer;
	}
}

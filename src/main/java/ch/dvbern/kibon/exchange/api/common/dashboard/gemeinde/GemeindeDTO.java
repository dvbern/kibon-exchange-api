/*
 * Copyright (C) 2022 DV Bern AG, Switzerland
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
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

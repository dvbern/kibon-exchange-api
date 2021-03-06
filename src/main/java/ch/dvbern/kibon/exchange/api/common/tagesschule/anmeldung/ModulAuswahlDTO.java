/*
 * Copyright (C) 2020 DV Bern AG, Switzerland
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

package ch.dvbern.kibon.exchange.api.common.tagesschule.anmeldung;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Entspricht einem durch die antragstellende Person ausgewählten Modul")
public class ModulAuswahlDTO implements Serializable {

	private static final long serialVersionUID = -2403935105004458699L;

	@Schema(description = "kiBon ID des ausgewählten Moduls")
	@NotNull
	@Size(min = 1)
	@Nonnull
	private String modulId;

	@Schema(description = "Ausgewählter Wochentag")
	@NotNull
	@Nonnull
	private DayOfWeek wochentag;

	@Schema(description = "Wie häufig das Modul besucht wird\n\nE.g. wöchentlich oder alle zwei Wochen")
	@NotNull
	@Nonnull
	private Intervall intervall;

	public ModulAuswahlDTO() {
		this.modulId = "";
		this.wochentag = DayOfWeek.MONDAY;
		this.intervall = Intervall.WOECHENTLICH;
	}

	public ModulAuswahlDTO(
		@Nonnull String modulId,
		@Nonnull DayOfWeek wochentag,
		@Nonnull Intervall intervall) {
		this.modulId = modulId;
		this.wochentag = wochentag;
		this.intervall = intervall;
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", ModulAuswahlDTO.class.getSimpleName() + '[', "]")
			.add("modulId='" + modulId + '\'')
			.add("wochentag=" + wochentag)
			.add("intervall=" + intervall)
			.toString();
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof ModulAuswahlDTO)) {
			return false;
		}

		ModulAuswahlDTO that = (ModulAuswahlDTO) o;

		return getModulId().equals(that.getModulId()) &&
			getWochentag() == that.getWochentag() &&
			getIntervall() == that.getIntervall();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getModulId(), getWochentag(), getIntervall());
	}

	@Nonnull
	public String getModulId() {
		return modulId;
	}

	public void setModulId(@Nonnull String modulId) {
		this.modulId = modulId;
	}

	@Nonnull
	public DayOfWeek getWochentag() {
		return wochentag;
	}

	public void setWochentag(@Nonnull DayOfWeek wochentag) {
		this.wochentag = wochentag;
	}

	@Nonnull
	public Intervall getIntervall() {
		return intervall;
	}

	public void setIntervall(@Nonnull Intervall intervall) {
		this.intervall = intervall;
	}
}

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

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Entspricht einem durch die antragstellende Person ausgewählten Modul")
public class ModulAuswahlDTO implements Serializable {

	private static final long serialVersionUID = -2403935105004458699L;

	@Schema(description = "kiBon ID des ausgewählten Moduls")
	@Nullable
	private String modulId = null;

	@Schema(description = "Benutzerdefinierte ID des ausgewählten Moduls")
	@Nullable
	private String fremdId = null;

	@Schema(description = "Ausgewählter Wochentag")
	@NotNull
	@Nonnull
	private DayOfWeek wochentag;

	@Schema(description = "Wie häufig das Modul besucht wird\n\nE.g. wöchentlich oder alle zwei Wochen")
	@NotNull
	@Nonnull
	private Intervall intervall;

	public ModulAuswahlDTO() {
		this.wochentag = DayOfWeek.MONDAY;
		this.intervall = Intervall.WOECHENTLICH;
	}

	public ModulAuswahlDTO(
		@Nullable String modulId,
		@Nonnull DayOfWeek wochentag,
		@Nonnull Intervall intervall,
		@Nullable String fremdId) {
		this.modulId = modulId;
		this.wochentag = wochentag;
		this.intervall = intervall;
		this.fremdId = fremdId;
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", ModulAuswahlDTO.class.getSimpleName() + '[', "]")
			.add("modulId='" + modulId + '\'')
			.add("wochentag=" + wochentag)
			.add("intervall=" + intervall)
			.add("fremdId=" + fremdId )
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

		return Objects.equals(getModulId(), that.getModulId()) &&
				Objects.equals(getFremdId(), that.getFremdId()) &&
			getWochentag() == that.getWochentag() &&
			getIntervall() == that.getIntervall();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getModulId(), getWochentag(), getIntervall(), getFremdId());
	}

	@Nullable
	public String getModulId() {
		return modulId;
	}

	public void setModulId(@Nullable String modulId) {
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

	@Nullable
	public String getFremdId() {
		return this.fremdId;
	}

	public void setFremdId(@Nullable String fremdId) {
		this.fremdId = fremdId;
	}
}

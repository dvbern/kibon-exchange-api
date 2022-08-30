/*
 * Copyright (C) 2021 DV Bern AG, Switzerland
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

package ch.dvbern.kibon.exchange.api.common.institution;

import java.time.LocalDate;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import ch.dvbern.kibon.exchange.api.common.shared.Mandant;
import ch.dvbern.kibon.exchange.api.common.shared.VonBisDatesDTO;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class ClientInstitutionDTO extends InstitutionDTO {

	private static final long serialVersionUID = 1213123607390163651L;

	@Schema(description = "Die Zugriffsrechte eines Clients können pro Institution auf ein Datums-Interval begrenzt "
		+ "werden. Dadurch lässt sich einschränken, welche Daten ein Client lesen kann.\n\n"
		+ "Beispielsweise erhält ein Client mit Zugriff per 2020-01-01 bis 2021-12-31 nur Betreuungsgutscheine in "
		+ "diesem Intervall. D.h. nur Verfügugen der Perioden 19/20, 20/21 und 21/22.\n\n"
		+ "Dadurch kann eine Clientanwendung veraltete/unrelevante Daten einfacher ignorieren.\n\n"
		+ "Dieses Intervall wird auch auf Seite-kiBon verwendet, um von Clientanwendungen eingehende Daten zu "
		+ "validieren. Daten ausserhalb des Intervalls werden nicht importiert.\n\n"
		+ "`von` und/oder `bis` können `NULL` sein. Diese entspricht einem offenen Intervall (keine "
		+ "Anfangs/End-Beschränkung).")
	@NotNull
	@Valid
	@Nonnull
	private VonBisDatesDTO clientBerechtigung = new VonBisDatesDTO();

	@Nonnull
	private Mandant mandant = Mandant.BERN;

	public ClientInstitutionDTO() {
	}

	public ClientInstitutionDTO(
		@Nonnull String id,
		@Nonnull String name,
		@Nonnull String traegerschaft,
		@Nonnull String strasse,
		@Nullable String hausnummer,
		@Nullable String adresszusatz,
		@Nonnull String plz,
		@Nonnull String ort,
		@Nonnull String land,
		@Nonnull Mandant mandant) {
		super(id, name, traegerschaft, strasse, hausnummer, adresszusatz, plz, ort, land);
	}

	public ClientInstitutionDTO(
		@Nonnull String id,
		@Nonnull String name,
		@Nonnull String traegerschaft,
		@Nonnull String strasse,
		@Nullable String hausnummer,
		@Nullable String adresszusatz,
		@Nonnull String plz,
		@Nonnull String ort,
		@Nonnull String land,
		@Nullable LocalDate berechtigtVon,
		@Nullable LocalDate berechtigtBis,
		@Nonnull Mandant mandant) {
		super(id, name, traegerschaft, strasse, hausnummer, adresszusatz, plz, ort, land);
		this.clientBerechtigung.setVon(berechtigtVon);
		this.clientBerechtigung.setBis(berechtigtBis);
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}

		ClientInstitutionDTO that = (ClientInstitutionDTO) o;

		return getMandant() == that.getMandant() &&
			getClientBerechtigung().equals(that.getClientBerechtigung());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getMandant(), getClientBerechtigung());
	}

	@Nonnull
	public VonBisDatesDTO getClientBerechtigung() {
		return clientBerechtigung;
	}

	public void setClientBerechtigung(@Nonnull VonBisDatesDTO clientBerechtigung) {
		this.clientBerechtigung = clientBerechtigung;
	}

	@Nonnull
	public Mandant getMandant() {
		return mandant;
	}

	public void setMandant(@Nonnull Mandant mandant) {
		this.mandant = mandant;
	}
}
